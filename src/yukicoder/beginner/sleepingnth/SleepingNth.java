package yukicoder.beginner.sleepingnth;

import java.time.LocalTime;
import java.util.Scanner;

public class SleepingNth {

	public static void main(String[] args) {
		new SleepingNth().execute();

	}

	private void execute() {
		SleepingDto dto = read();

		LocalTime wakeUpTime = dto.firstWakeTime;
		for (int i = 1; i < dto.sleepingNum; i++) {
			wakeUpTime = wakeUpTime.plusMinutes(dto.alermInterval);
		}
		System.out.println(wakeUpTime.getHour());
		System.out.println(wakeUpTime.getMinute());
	}

	private SleepingDto read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return new SleepingDto(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
	}

	private class SleepingDto {
		private int sleepingNum;
		private LocalTime firstWakeTime;
		private int alermInterval;
		private SleepingDto(int sleepingNum, int firstWakeHour, int firstWakeMin, int interval) {
			this.sleepingNum = sleepingNum;
			this.firstWakeTime = LocalTime.of(firstWakeHour, firstWakeMin);
			this.alermInterval = interval;
		}
	}
}
