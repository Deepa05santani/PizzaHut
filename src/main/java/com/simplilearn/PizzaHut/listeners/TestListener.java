package com.simplilearn.PizzaHut.listeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("====== Pizza Hut Test Suite Started: " + context.getName() + " ======");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(">> Running Test Case: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASS: Test Case [" + result.getMethod().getMethodName() + "] completed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.err.println("FAIL: Test Case [" + result.getMethod().getMethodName() + "] failed execution!");
        System.err.println("Reason for Failure: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIP: Test Case [" + result.getMethod().getMethodName() + "] was skipped.");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("====== Pizza Hut Test Suite Finished: " + context.getName() + " ======");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not used, but required by ITestListener implementation constraints
    }
}