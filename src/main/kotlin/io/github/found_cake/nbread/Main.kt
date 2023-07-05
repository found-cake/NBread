package io.github.found_cake.nbread

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.requests.GatewayIntent

fun main(){
	val token = ""//your discord bot token
	val jda: JDA = JDABuilder.createDefault(token)
		.enableIntents(GatewayIntent.MESSAGE_CONTENT)
		.build()
	jda.addEventListener(EventListener())

	jda.updateCommands().addCommands(
		Commands.slash("nbread", "N빵 금액을 연산합니다.")
			.addOption(OptionType.INTEGER, "금액", "지불한 금액", true)
			.addOption(OptionType.INTEGER, "입금인원", "지불한 사람을 제외한 인원", true)
			.addOptions(
				OptionData(OptionType.INTEGER, "최소단위", "입금 단위를 지정할 수 있습니다")
					.setRequired(false)
					.addChoice("없음", 1)
					.addChoice("10", 10)
					.addChoice("100", 100)
					.addChoice("1000", 1000)
			)
	).queue()
}