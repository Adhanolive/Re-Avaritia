package committee.nova.mods.avaritia.common.level;

import committee.nova.mods.avaritia.init.registry.ModAttachments;
import committee.nova.mods.avaritia.init.registry.ModDamageSources;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Function;

/**
 * @Project: Avaritia-forge
 * @Author: cnlimiter
 * @CreateTime: 2024/2/12 14:30
 * @Description:
 */

public class LevelDamage {
    public static Optional<ModDamageSources> getOpt(@NotNull Level level) {
        return Optional.of(level.getData(ModAttachments.LEVEL_DAMAGE)).map(LevelDamage::getModDamageSources);
    }

    private final ModDamageSources modDamageSources;

    public LevelDamage(Level level) {
        this.modDamageSources = new ModDamageSources(level.registryAccess());
    }

    private ModDamageSources getModDamageSources() {
        return modDamageSources;
    }

    public static class Factory implements Function<IAttachmentHolder, LevelDamage> {

        @Override
        public LevelDamage apply(IAttachmentHolder holder) {
            if (holder instanceof Level level) {
                return new LevelDamage(level);
            }
            throw new IllegalArgumentException("Cannot create level damage for holder " + holder.getClass() + ". Expected Level");
        }
    }
}
