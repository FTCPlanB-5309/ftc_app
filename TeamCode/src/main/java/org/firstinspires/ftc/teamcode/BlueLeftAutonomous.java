package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;






@Autonomous(name="Left Blue Autonomous", group="Blue")

public class BlueLeftAutonomous extends LinearOpMode {

    //
    // Creating the robot class from the Plan B Hardware class and passing in telemetry
    // object as a parameter so that the hardware class can spit out telemetry data
    //
    RobotHardware         robot   = new RobotHardware(telemetry);
    Jewel                 jewel   = new Jewel(robot, telemetry);
    Forward forward = new Forward(robot,telemetry);
    Gyro gyro = new Gyro(robot, telemetry);
//    SonicAlign sonicAlign = new SonicAlign(robot, telemetry, slide);
    ArmHandler armHandler = new ArmHandler(robot, telemetry);
//    AutoPosition autoPosition = new AutoPosition(robot,telemetry);
    ColorSensorSlide colorSensorSlide = new ColorSensorSlide(robot, telemetry);
    Glyph glyph = new Glyph(robot, telemetry);
    GyroForward gyroForward = new GyroForward(robot, telemetry);

    public void runOpMode() throws InterruptedException {
        double distanceForward;
        robot.init(hardwareMap);
        waitForStart();
        jewel.JewelSwatter(robot.BLUE);
        glyph.grabber(robot.CLOSE);
        armHandler.armToPosition(400);
        gyroForward.sonic(14);
        colorSensorSlide.findColumn(robot.BLUE, RelicRecoveryVuMark.RIGHT, robot.RIGHT);
        gyro.turn(0);
        forward.run(0.25, 8);
        glyph.grabber(robot.SOFT);
        forward.run(0.25, -8);

    }

}
