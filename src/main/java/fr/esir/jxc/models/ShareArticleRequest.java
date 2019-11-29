package fr.esir.jxc.models;

import lombok.Data;

import java.util.List;

@Data
public class ShareArticleRequest {
    List<String> targetEmails;
}
