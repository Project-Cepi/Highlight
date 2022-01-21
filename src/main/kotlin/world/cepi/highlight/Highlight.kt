package world.cepi.highlight

import net.kyori.adventure.text.format.NamedTextColor
import net.minestom.server.MinecraftServer
import net.minestom.server.coordinate.Point
import net.minestom.server.entity.EntityType
import net.minestom.server.entity.LivingEntity
import net.minestom.server.instance.Instance
import java.time.Duration

class Highlight(val instance: Instance, val position: Point) {

    val entity = LivingEntity(EntityType.SHULKER)

    init {
        entity.setInstance(instance, position)
        highlighters.add(this)
    }

    fun color(color: NamedTextColor) {
        entity.team.teamColor = color
    }

    fun removeAfter(duration: Duration) {
        MinecraftServer.getSchedulerManager().buildTask {
            remove()
        }.delay(duration).schedule()
    }

    fun remove() {
        entity.remove()
        highlighters.remove(this)
    }

    companion object {
        val highlighters = mutableListOf<Highlight>()
    }

}