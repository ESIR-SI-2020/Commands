package fr.esir.jxc.models;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Article {

    @NonNull
    private String id;
    @NonNull
    private String url;

    private List<String> tags;
    private List<String> suggestedTags;

}
