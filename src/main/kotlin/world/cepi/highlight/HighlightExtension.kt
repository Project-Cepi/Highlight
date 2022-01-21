package world.cepi.highlight

import net.minestom.server.extensions.Extension;

class HighlightExtension : Extension() {

    override fun initialize(): LoadStatus {
        logger().info("[Highlight] has been enabled!")

        return LoadStatus.SUCCESS
    }

    override fun terminate() {
        Highlight.highlighters.forEach { it.remove() }

        logger().info("[Highlight] has been disabled!")
    }

}
