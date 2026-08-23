package com.FundooNotesApp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.FundooNotesApp.dto.response.NoteResponseDTO;
import com.FundooNotesApp.entity.Note;
import com.FundooNotesApp.entity.User;
import com.FundooNotesApp.mapper.NoteMapper;
import com.FundooNotesApp.repository.NoteRepository;
import com.FundooNotesApp.repository.UserRepository;
import com.FundooNotesApp.service.impl.NoteServiceImpl;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private NoteMapper noteMapper;

    @InjectMocks
    private NoteServiceImpl noteService;

    private User testUser;
    private Note testNote;
    private NoteResponseDTO testNoteResponseDTO;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(1L);
        testUser.setEmail("test@example.com");

        testNote = new Note();
        testNote.setNoteId(100L);
        testNote.setTitle("Test Title");
        testNote.setContent("Test Content");
        testNote.setOwner(testUser);

        testNoteResponseDTO = new NoteResponseDTO(100L, "Test Title", "Test Content", testNote.getCreatedAt());
    }

    @Test
    void testCreateNote_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(noteRepository.save(any(Note.class))).thenReturn(testNote);
        when(noteMapper.toResponseDTO(testNote)).thenReturn(testNoteResponseDTO);

        NoteResponseDTO result = noteService.createNote(1L, "Test Title", "Test Content");

        assertNotNull(result);
        assertEquals("Test Title", result.getTitle());
        assertEquals("Test Content", result.getContent());
        verify(noteRepository, times(1)).save(any(Note.class));
    }

    @Test
    void testFindByOwner_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(noteRepository.findByOwner(testUser)).thenReturn(List.of(testNote));
        when(noteMapper.toResponseDTO(testNote)).thenReturn(testNoteResponseDTO);

        List<NoteResponseDTO> results = noteService.findByOwner(1L);

        assertEquals(1, results.size());
        assertEquals("Test Title", results.get(0).getTitle());
    }

    @Test
    void testUpdateNote_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(noteRepository.findByNoteIdAndOwner(100L, testUser)).thenReturn(Optional.of(testNote));
        when(noteRepository.save(any(Note.class))).thenReturn(testNote);
        
        NoteResponseDTO updatedResponseDTO = new NoteResponseDTO(100L, "Updated Title", "Updated Content", testNote.getCreatedAt());
        when(noteMapper.toResponseDTO(testNote)).thenReturn(updatedResponseDTO);

        NoteResponseDTO result = noteService.updateNote(100L, "Updated Title", "Updated Content", 1L);

        assertNotNull(result);
        assertEquals("Updated Title", result.getTitle());
        assertEquals("Updated Content", result.getContent());
        verify(noteRepository, times(1)).save(testNote);
    }

    @Test
    void testDeleteNote_Success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(noteRepository.findByNoteIdAndOwner(100L, testUser)).thenReturn(Optional.of(testNote));

        boolean deleted = noteService.deleteNote(100L, 1L);

        assertTrue(deleted);
        verify(noteRepository, times(1)).delete(testNote);
    }

    @Test
    void testDeleteNote_NotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(noteRepository.findByNoteIdAndOwner(100L, testUser)).thenReturn(Optional.empty());

        boolean deleted = noteService.deleteNote(100L, 1L);

        assertFalse(deleted);
        verify(noteRepository, never()).delete(any());
    }
}
