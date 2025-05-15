package com.example.classRoomAPI.helpers;

public enum MessagesApi {
    ERROR_TEACHER_NO_ENCONTRADO("el docente que buscas, no esta en la base de datos"),
    ERROR_STUDENT_NO_ENCONTRADO("El estudiante  buscas, no esta en la base de datos"),
    ERROR_SUBJECT_NO_ENCONTRADO("el docente que buscas, no esta en la base de datos"),
    ERROR_GRADE_NO_ENCONTRADO("el docente que buscas, no esta en la base de datos"),
    ERROR_COURSE_NO_ENCONTRADO("el docente que buscas, no esta en la base de datos"),
    ERROR_ATTENDANCE_NO_ENCONTRADO("el docente que buscas, no esta en la base de datos"),
    ERROR_TUITION_NO_ENCONTRADO("el docente que buscas, no esta en la base de datos"),
    ERROR_USER_NO_ENCONTRADO("el docente que buscas, no esta en la base de datos")
    ;

    private String menssages;

    MessagesApi(String menssages) {
        this.menssages = menssages;
    }

    public String getMenssages() {
        return menssages;
    }
}
