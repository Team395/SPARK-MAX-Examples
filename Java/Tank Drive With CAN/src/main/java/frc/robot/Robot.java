/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private static final int leftDeviceID = 1; 
  private static final int leftDeviceID2 = 3; 
  private static final int rightDeviceID = 2;
  private static final int rightDeviceID2 = 4;
  private CANSparkMax m_leftMotor;
  private CANSparkMax m_leftMotor2;
  private CANSparkMax m_rightMotor;
  private CANSparkMax m_rightMotor2;
  SpeedControllerGroup m_left;
  SpeedControllerGroup m_right;

  @Override
  public void robotInit() {
  /**
   * SPARK MAX controllers are intialized over CAN by constructing a CANSparkMax object
   * 
   * The CAN ID, which can be configured using the SPARK MAX Client, is passed as the
   * first parameter
   * 
   * The motor type is passed as the second parameter. Motor type can either be:
   *  com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushless
   *  com.revrobotics.CANSparkMaxLowLevel.MotorType.kBrushed
   * 
   * The example below initializes four brushless motors with CAN IDs 1 and 2. Change
   * these parameters to match your setup
   */
  m_leftMotor = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
  m_leftMotor2 = new CANSparkMax(leftDeviceID2, MotorType.kBrushless);
  m_rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless);
  m_rightMotor2 = new CANSparkMax(rightDeviceID2, MotorType.kBrushless);

  m_left = new SpeedControllerGroup(m_leftMotor, m_leftMotor2);
  m_right = new SpeedControllerGroup(m_rightMotor, m_rightMotor2);

    m_myRobot = new DifferentialDrive(m_left, m_right);

    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
  }
}
