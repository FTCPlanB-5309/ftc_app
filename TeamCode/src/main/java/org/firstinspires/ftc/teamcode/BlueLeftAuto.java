package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.RobotHardware;
import org.firstinspires.ftc.robotcontroller.external.samples.ConceptVuforiaNavigation;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;


@Autonomous(name="Left Blue Autonomous", group="Blue")

public class BlueLeftAuto extends LinearOpMode {

    //
    // Creating the robot class from the Plan B Hardware class and passing in telemetry
    // object as a parameter so that the hardware class can spit out telemetry data
    //
    RobotHardware         robot   = new RobotHardware(telemetry);
    Jewel                 jewel   = new Jewel(robot, telemetry);
    Forward forward = new Forward(robot,telemetry);
    Slide slide = new Slide(robot, telemetry);
    Gyro gyro = new Gyro(robot, telemetry);
    SonicAlign sonicAlign = new SonicAlign(robot, telemetry, slide);

    public void runOpMode() throws InterruptedException {
        double distanceForward;


        robot.init(hardwareMap);
//        ConceptVuMarkId conceptVuMarkId = new ConceptVuMarkId(hardwareMap, telemetry);
        RelicRecoveryVuMark columnPosition = RelicRecoveryVuMark.LEFT;
        waitForStart();
        robot.gyroSensor.resetZAxisIntegrator();
//        jewel.JewelSwatter(robot.BLUE);
//        sleep(500);
//        columnPosition = conceptVuMarkId.findColumn(5000);
//        telemetry.addData("Column Position", columnPosition);
//        telemetry.update();
        robot.leftClaw.setPosition(robot.LEFT_CLAW_CLOSED);
        robot.rightClaw.setPosition(robot.RIGHT_CLAW_CLOSED);
        sleep(500);
        robot.armMotor.setPower(0.25);
        sleep(600);
        robot.armMotor.setPower(0);
        sleep(500);
        forward.run(0.25, 31);
        sleep(500);
        gyro.turn(0);
        //slide.run(0.5, 6, robot.LEFT);
        distanceForward = sonicAlign.run(columnPosition);
        forward.run(0.5, (int)distanceForward);
        slide.run(0.5, 36, robot.RIGHT);
        forward.run(0.25, 18);
        slide.run(0.25, 12, robot.LEFT);
//
//        robot.leftClaw.setPosition(robot.LEFT_CLAW_OPEN);
//        robot.rightClaw.setPosition(robot.RIGHT_CLAW_OPEN);
//        forward.run(0.2, -6);

    }
}
