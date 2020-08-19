package com.es.camp.designmodel.builder;

public class Main {

    public static void main(String[] args) {
        TerrainBuilder terrainBuilder = new ComplexTerrainBuilder();
        terrainBuilder.buildWall()
                .buildFort()
                .buildMine();
        Terrain terrain = terrainBuilder.build();

        System.out.println(terrain + " 已建成.");
    }
}
