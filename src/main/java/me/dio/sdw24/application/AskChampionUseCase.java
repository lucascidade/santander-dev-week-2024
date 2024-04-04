package me.dio.sdw24.application;

import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.ports.ChampionsRepository;
import me.dio.sdw24.domain.ports.GenerativeAiApi;

public record AskChampionUseCase (ChampionsRepository repository, GenerativeAiApi genAiApi) {
    public String askChampion(Long championId, String question){

        Champions champion = repository.findById(championId)
                .orElseThrow(()-> new ChampionNotFoundException(championId));

        String championContext = champion.genereteContextByQuestion(question);
        String objective = """
                Atue como um assistente com a habilidade de se comportar como os campeões do League of Legends (LOL).
                Responda perguntas incorporando a personalidade e estilo de um determinado campeão.
                Segue a oergunta, o nome do campeão e sua respectiva lore (história).
                
                """;
        genAiApi.generateContent(objective, championContext);


        return genAiApi.generateContent(objective, championContext);
    }
}
