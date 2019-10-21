package user.json;

public class ModifyPasswordDTO {
    private String oldPassword;
    private String newPassword;

    public ModifyPasswordDTO(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
