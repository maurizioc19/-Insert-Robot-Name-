package org.usfirst.frc.team1797.robot;

import org.usfirst.frc.team1797.util.AnalogForceResistor;
import org.usfirst.frc.team1797.util.AnalogUltrasonicSensor;

import edu.wpi.first.wpilibj.ADXL362;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	/*
	 * PWM: 0 - DT Victor Left; 1 - DT Victor Right; 2 - GEAR Intake; 3 -
	 * CLIMBER;
	 *  
	 * DIO: 0 - DT Encoder Left; 1 - DT Encoder Left; 2 - DT Encoder Right; 3 -
	 * DT Encoder Right;
	 * 
	 * PCM: 0 - GEAR Piston, 1 - GEAR Piston;
	 * 
	 */

	// Components necessary for Drivetrain
	public static RobotDrive DRIVETRAIN_ROBOT_DRIVE;

	public static Encoder DRIVETRAIN_ENCODER_LEFT, DRIVETRAIN_ENCODER_RIGHT;

	public static ADXRS450_Gyro DRIVETRAIN_GYRO;
	public static ADXL362 DRIVETRAIN_ACCEL;
	public static AnalogUltrasonicSensor DRIVETRAIN_ULTRASONIC;

	// Components necessary for Active Gear
	public static VictorSP GEAR_INTAKE;
	public static DoubleSolenoid GEAR_PISTON;
	public static AnalogForceResistor GEAR_FORCE_LEFT, GEAR_FORCE_RIGHT;

	// Components necessary for Climber
	public static VictorSP CLIMBER;

	public static void init() {

		// Drivetrain
		DRIVETRAIN_ROBOT_DRIVE = new RobotDrive(0, 1);

		DRIVETRAIN_ENCODER_LEFT = new Encoder(0, 1);
		DRIVETRAIN_ENCODER_LEFT.setDistancePerPulse(0.0481);
		SmartDashboard.putData("Drivetrain Left Encoder", DRIVETRAIN_ENCODER_LEFT);

		DRIVETRAIN_ENCODER_RIGHT = new Encoder(2, 3);
		DRIVETRAIN_ENCODER_RIGHT.setDistancePerPulse(0.0481);
		SmartDashboard.putData("Drivetrain Right Encoder", DRIVETRAIN_ENCODER_RIGHT);

		DRIVETRAIN_GYRO = new ADXRS450_Gyro();
		SmartDashboard.putData("Drivetrain Gyro", DRIVETRAIN_GYRO);

		DRIVETRAIN_ACCEL = new ADXL362(Range.k8G);
		
		DRIVETRAIN_ULTRASONIC = new AnalogUltrasonicSensor(0);

		// Active Gear
		GEAR_INTAKE = new VictorSP(2);
		GEAR_PISTON = new DoubleSolenoid(0, 1);

		GEAR_FORCE_LEFT = new AnalogForceResistor(1);
		GEAR_FORCE_RIGHT = new AnalogForceResistor(2);

		// Climber
		CLIMBER = new VictorSP(3);
	}

}
