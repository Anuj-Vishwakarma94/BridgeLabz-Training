package com.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminService {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User Deleted");
    }
}

public class RoleBasedAccess {
    public static void main(String[] args) throws Exception {
        String currentRole = "USER";
        AdminService a = new AdminService();

        Method m = AdminService.class.getMethod("deleteUser");
        RoleAllowed r = m.getAnnotation(RoleAllowed.class);

        if (r.value().equals(currentRole))
            m.invoke(a);
        else
            System.out.println("Access Denied!");
    }
}
