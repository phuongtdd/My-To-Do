package spring.todoapp.exception;

public enum ErrorCode {

    USER_EXISTED(1001, "User already exists"),
    USER_NOT_EXISTED(1002, "User does not exist"),
    PASSWORD_SIZE(1003, "Password length should be between 6 and 16"),
    USERNAME_SIZE(1003, "Username length should be between 6 and 16"),
    LOGIN_SUCCESS(1005, "User logged in successfully"),
    INVALID_EMAIL(1006, "Invalid email address"),
    TASK_NOT_EXISTED(1007, "Task does not exist");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
