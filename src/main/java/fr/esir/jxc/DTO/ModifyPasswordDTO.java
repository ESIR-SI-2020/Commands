package fr.esir.jxc.DTO;
import lombok.Value;

@Value
public class ModifyPasswordDTO {
    private String oldPassword;
    private String newPassword;
}
