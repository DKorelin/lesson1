package io.metadevs.dkorelin;

import io.metadevs.dkorelin.plants.Plant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Biome {

    private static final Logger logger = LogManager.getLogger(Biome.class);
    private final ArrayList<Plant> plants = new ArrayList<>();

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public boolean[][] plantsEquality() {
        boolean[][] equalityMatrix = new boolean[plants.size()][plants.size()];
        for (int i = 0; i < plants.size(); i++) {
            Plant plant = plants.get(i);
            for (int j = 0; j < plants.size(); j++) {
                Plant plant2 = plants.get(j);
                equalityMatrix[i][j] = plant.equals(plant2);
            }
            logger.debug("equality matrix row {} : {}", i, equalityMatrix[i]);
        }
        return equalityMatrix;
    }
}
