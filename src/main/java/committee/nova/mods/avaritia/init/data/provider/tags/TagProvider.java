package committee.nova.mods.avaritia.init.data.provider.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 * @Project: Avaritia-forge
 * @Author: cnlimiter
 * @CreateTime: 2024/2/12 19:16
 * @Description:
 */

public class TagProvider {
    public static void register(DataGenerator gen, @NotNull GatherDataEvent event, PackOutput output, CompletableFuture<HolderLookup.Provider> future, ExistingFileHelper existingFileHelper) {
        ModBlockTagProvider blockTagsProvider = new ModBlockTagProvider(output, future, existingFileHelper);
        gen.addProvider(event.includeServer(), blockTagsProvider);
        gen.addProvider(event.includeServer(), new ModItemTagProvider(output, future, blockTagsProvider.contentsGetter(), existingFileHelper));
        gen.addProvider(event.includeServer(), new ModEntityTypeTagsProvider(output, future, existingFileHelper));
        //gen.addProvider(event.includeServer(), new ModFluidTagsProvider(output, future, existingFileHelper));
        //gen.addProvider(event.includeServer(), new ModBiomeTagsProvider(output, future, existingFileHelper));
        //gen.addProvider(event.includeServer(), new ModPoiTypeProvider(output, future, existingFileHelper));
        //gen.addProvider(event.includeServer(), new ModVillageProfessionProvider(output, future, existingFileHelper));
        gen.addProvider(event.includeServer(), new ModDamageTypeProvider(output, future, existingFileHelper));
        //gen.addProvider(event.includeServer(), new ModTasksProvider(output, future, existingFileHelper));
        //gen.addProvider(event.includeServer(), new ModStructuresProvider(output, future, existingFileHelper));
    }
}
