package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.Duration;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {
	public static void main(String[] args) {
		// Instanciação: (Agora) --> Data-hora
		LocalDate d01 = LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		Instant d03 = Instant.now();

		System.out.println("d01 = " + d01.toString());
		System.out.println("d02 = " + d02.toString());
		System.out.println("d03 = " + d03.toString());

		// Instanciação: Texto ISO 8601 --> Data-hora
		LocalDate d04 = LocalDate.parse("2022-07-20");
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
		Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");

		System.out.println("d04 = " + d04.toString());
		System.out.println("d05 = " + d05.toString());
		System.out.println("d06 = " + d06.toString());
		System.out.println("d07 = " + d07.toString());

		// Instanciação: Texto formato customizado --> Data-hora
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
		LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);

		System.out.println("d08 = " + d08.toString());
		System.out.println("d09 = " + d09.toString());

		// Instanciação: Dia, mês, ano, [horário] --> Data-hora local
		LocalDate d10 = LocalDate.of(2022, 7, 20);
		LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);

		System.out.println("d10 = " + d10.toString());
		System.out.println("d11 = " + d11.toString());

		// Formatação: Data-hora --> Texto ISO 8601 / Data-hora --> Texto formato customizado
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

		System.out.println("d04 = " + d04.format(fmt1));
		System.out.println("d04 = " + d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("d04 = " + fmt1.format(d04));
		System.out.println("d05 = " + d05.format(fmt2));
		System.out.println("d06 = " + fmt3.format(d06));

		// Converter data-hora global para local: Data-hora global, timezone (Sistema local) --> Data-hora local
		LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
		LocalDateTime r2 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
		LocalDate r3 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
		LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2);
		System.out.println("r3 = " + r3);
		System.out.println("r4 = " + r4);

		// Obter dados de uma data-hora local: Data-hora local --> dia, mês, ano, horário
		System.out.println("d04 Dia = " + d04.getDayOfMonth());
		System.out.println("d04 Mês = " + d04.getMonthValue());
		System.out.println("d04 Ano = " + d04.getYear());
		System.out.println("d05 Hora = " + d05.getHour());
		System.out.println("d05 Minuto = " + d05.getMinute());

		// Cálculos com data-hora: Data-hora +/- tempo --> Data-hora
		LocalDate pastWeekLocalDate = d04.minusDays(7);
		LocalDate nextWeekLocalDate = d04.plusDays(7);
		LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
		LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);
		Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
		Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

		System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
		System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
		System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
		System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);
		System.out.println("pastWeekInstant = " + pastWeekInstant);
		System.out.println("nextWeekInstant = " + nextWeekInstant);

		// Cálculos com data-hora: Data-hora 1, Data-hora 2 --> Duração
		Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
		Duration t2 = Duration.between(pastWeekLocalDateTime, d05);
		Duration t3 = Duration.between(pastWeekInstant, d06);
		Duration t4 = Duration.between(d06, pastWeekInstant);

		System.out.println("t1 Dias = " + t1.toDays());
		System.out.println("t2 Dias = " + t2.toDays());
		System.out.println("t3 Dias = " + t3.toDays());
		System.out.println("t4 Dias = " + t4.toDays());
	}
}