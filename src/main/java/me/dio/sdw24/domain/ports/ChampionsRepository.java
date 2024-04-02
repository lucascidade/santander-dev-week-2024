package me.dio.sdw24.domain.ports;

import me.dio.sdw24.domain.model.Champions;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {

    List<Champions> finAll();

    Optional<Champions> findById(Long id);
}
