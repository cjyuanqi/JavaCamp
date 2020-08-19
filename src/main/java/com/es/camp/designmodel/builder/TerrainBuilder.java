package com.es.camp.designmodel.builder;

public interface TerrainBuilder {

    TerrainBuilder buildWall();
    TerrainBuilder buildFort();
    TerrainBuilder buildMine();

    Terrain build();
}
