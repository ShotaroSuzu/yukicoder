package yukicoder.beginner.firststep;

import java.util.Scanner;

public class CalcSteps {

	public static void main(String[] args) {
		new CalcSteps().execute();
	}

	private void execute() {
		CalcStepsDto dto = read();

		boolean isJust = dto.length % dto.lengthPerStep == 0;
		long steps = dto.length / dto.lengthPerStep;

		 if(isJust) {
			 System.out.println(steps);
		 } else {
			 System.out.println(steps + 1);
		 }
	}

	private CalcStepsDto read() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		return new CalcStepsDto(sc.nextLong(), sc.nextLong());
	}

	private class CalcStepsDto {
		private long length;
		private long lengthPerStep;

		private CalcStepsDto(long lengthPerStep, long length) {
			this.lengthPerStep = lengthPerStep;
			this.length = length;
		}
	}
}
