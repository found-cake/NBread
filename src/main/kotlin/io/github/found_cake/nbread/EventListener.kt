package io.github.found_cake.nbread

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class EventListener: ListenerAdapter() {

	override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
		if(event.name != "nbread")return
		val money: Int = event.getOption("금액")!!.asInt
		val people: Int = event.getOption("입금인원")!!.asInt + 1
		val least : Int = event.getOption("최소단위")?.asInt ?: 1
		var pay: Int = money / people
		pay -= pay % least
		event.channel.sendMessageEmbeds(
			EmbedBuilder()
				.setTitle("N빵")
				.setColor(Color(0x00D0F5BE))
				.addField("입금금액", "$pay 원", false)
				.addField("부담금", "${money - (pay * people)} 원", false)
				.build()
		).queue()
	}
}