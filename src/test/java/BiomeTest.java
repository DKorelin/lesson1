import io.metadevs.dkorelin.Biome;
import io.metadevs.dkorelin.plants.Bush;
import io.metadevs.dkorelin.plants.Herb;
import io.metadevs.dkorelin.plants.Tree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static io.metadevs.dkorelin.plants.TreeResource.*;
import static org.junit.jupiter.api.Assertions.*;


class BiomeTest {
    private static final Logger logger = LogManager.getLogger(Biome.class);
    @Test
    void plantsEqualityAllDiffer() {
        logger.debug("plantsEqualityAllDiffer test started");
        Biome testBiome = new Biome();
        testBiome.addPlant(new Herb("chamomile",10));
        testBiome.addPlant(new Herb("ginger", 5));
        testBiome.addPlant(new Herb("dandelion", 14));
        testBiome.addPlant(new Bush("coffee", 7,true));
        testBiome.addPlant(new Bush("currant", 6,true));
        testBiome.addPlant(new Bush("rhododendron", 12,false));
        testBiome.addPlant(new Bush("tea", 12,false));
        testBiome.addPlant(new Tree("apple",25,false, FOOD));
        testBiome.addPlant(new Tree("birch",20,false, FUEL));
        testBiome.addPlant(new Tree("cedar",50,true, TIMBER));
        testBiome.addPlant(new Tree("sakura",30,true, DECORATION));
        boolean[][] goldenMatrix = {
                {true ,false,false,false,false,false,false,false,false,false,false},
                {false,true ,false,false,false,false,false,false,false,false,false},
                {false,false,true ,false,false,false,false,false,false,false,false},
                {false,false,false,true ,false,false,false,false,false,false,false},
                {false,false,false,false,true ,false,false,false,false,false,false},
                {false,false,false,false,false,true ,false,false,false,false,false},
                {false,false,false,false,false,false,true ,false,false,false,false},
                {false,false,false,false,false,false,false,true ,false,false,false},
                {false,false,false,false,false,false,false,false,true ,false,false},
                {false,false,false,false,false,false,false,false,false,true ,false},
                {false,false,false,false,false,false,false,false,false,false,true }
        };
        boolean[][] revisionMatrix = testBiome.plantsEquality();
        assertArrayEquals(goldenMatrix,revisionMatrix);
    }

    @Test
    void plantsEqualityAllSame() {
        logger.debug("plantsEqualityAllSame test started");
        Biome testBiome = new Biome();
        testBiome.addPlant(new Herb("chamomile",10));
        testBiome.addPlant(new Herb("chamomile",10));
        testBiome.addPlant(new Herb("chamomile",10));
        testBiome.addPlant(new Herb("chamomile",10));
        boolean[][] goldenMatrix = {
                {true,true,true,true},
                {true,true,true,true},
                {true,true,true,true},
                {true,true,true,true}
        };
        boolean[][] revisionMatrix = testBiome.plantsEquality();
        assertArrayEquals(goldenMatrix,revisionMatrix);
    }

    @Test
    void plantsEqualityTwoEqual() {
        logger.debug("plantsEqualityTwoEqual test started");
        Biome testBiome = new Biome();
        testBiome.addPlant(new Herb("chamomile",10));
        testBiome.addPlant(new Herb("ginger", 5));
        testBiome.addPlant(new Herb("ginger", 5));
        testBiome.addPlant(new Bush("coffee", 7,true));
        testBiome.addPlant(new Bush("currant", 6,true));
        testBiome.addPlant(new Tree("apple",25,false, FOOD));
        testBiome.addPlant(new Tree("birch",20,false, FUEL));
        boolean[][] goldenMatrix = {
                {true ,false,false,false,false,false,false},
                {false,true ,true ,false,false,false,false},
                {false,true ,true ,false,false,false,false},
                {false,false,false,true ,false,false,false},
                {false,false,false,false,true ,false,false},
                {false,false,false,false,false,true ,false},
                {false,false,false,false,false,false,true }
        };
        boolean[][] revisionMatrix = testBiome.plantsEquality();
        assertArrayEquals(goldenMatrix,revisionMatrix);
    }
}