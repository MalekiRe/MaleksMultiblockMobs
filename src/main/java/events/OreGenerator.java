package events;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import com.malekire.multiblockspawn.Main;
import com.malekire.multiblockspawn.util.Reference;
import static com.malekire.multiblockspawn.util.TheOreNames.OreNames.OreNames;
import static com.malekire.multiblockspawn.config.ConfigLoader.*;
public class OreGenerator implements IWorldGenerator {
	
        
    
	
    private Block[] blocks = {Blocks.COAL_ORE, Blocks.IRON_ORE, Blocks.GOLD_ORE, Blocks.DIAMOND_ORE, Blocks.REDSTONE_ORE, Blocks.EMERALD_ORE, Blocks.DIRT, Blocks.GRAVEL, Blocks.STONE.getStateFromMeta(1).getBlock(), Blocks.STONE.getStateFromMeta(3).getBlock(), Blocks.STONE.getStateFromMeta(4).getBlock(), Blocks.STONE.getStateFromMeta(5).getBlock()};

    private void generateOres(World world, Random random, int x, int z) {
    	//Main.logger.info(disableOres[1]);
    	//Main.logger.info("YES");
    	//Main.logger.info(OreNames.length);
        for (int ore = 0; ore < OreNames.length; ore++) {
        	//Main.logger.info("ALso here");
            if (disableOres[ore] && enableCustomOreGeneration[ore]) {
        			//Main.logger.info(spawnRates[ore]);
                for (int i = 0; i < spawnRates[ore]; i++) {
                    int veinYLevel = (int) (Math.random() * (maxVeinLevels[ore] - minVeinLevels[ore])) + minVeinLevels[ore];
                    int veinSize = (int) (Math.random() * (maxVeinSizes[ore] -minVeinSizes[ore]) + minVeinSizes[ore]);
                    
                    //Main.logger.info("dasfasd");
                    int xCoord = x + random.nextInt(16);
                    int zCoord = z + random.nextInt(16);
                    //System.out.println("dadfs");
                    new WorldGenMinable(blocks[ore].getDefaultState(), veinSize).generate(world, random, new BlockPos(xCoord, veinYLevel, zCoord));
                }
            }
        }
    }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		//Main.logger.info("HELLO");
		//Main.logger.info(world.provider.getDimension());
		switch (world.provider.getDimension()) {
        case 0 : generateOres(world, random, chunkX * 16, chunkZ * 16);
    }
		
	}
}
