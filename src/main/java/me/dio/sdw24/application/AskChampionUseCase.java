package me.dio.sdw24.application;

import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import me.dio.sdw24.domain.model.Champions;
import me.dio.sdw24.domain.ports.ChampionsRepository;

public record AskChampionUseCase (ChampionsRepository repository) {
    public String askChampion(Long championId, String question){

        Champions champion = repository.findById(championId)
                .orElseThrow(()-> new ChampionNotFoundException(championId));

        String championContext = champion.genereteContextByQuestion(question);
        return championContext;
    }
}
