package org.micap.login_registro;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Warren Stehen Aroni Soto.
 * User: warrenxxx
 * Date: 27/02/2018
 * Time: 20:14
 */

public class ExecuteAllTest {
    public static void main(String[] args) {


        Result result = JUnitCore.runClasses(LoginRegistroIntegrationTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

        result = JUnitCore.runClasses(LoginRegistroIntegrationTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
