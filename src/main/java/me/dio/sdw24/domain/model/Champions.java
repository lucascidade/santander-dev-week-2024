package me.dio.sdw24.domain.model;

public record Champions(
        Long id,
        String name,
        String role,
        String lore,
        String imageUrl
) {

    public String genereteContextByQuestion(String question){
        return """
                Pergunta: %s
                Campeão: %s 
                Função: %s
                Lore: %s
                """.formatted(question, name, role, lore);
    }
}
