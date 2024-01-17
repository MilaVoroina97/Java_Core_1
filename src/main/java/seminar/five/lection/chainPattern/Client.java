package seminar.five.lection.chainPattern;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Client {

    public static void main(String[] args) {
        String s = "Chain chain = new Chain();";

        StatementHandler lineEndHandler = new LineEndHandler();
        StatementHandler lengthHandler = new LengthHandler();
        StatementHandler valHandler = new ValHandler();

        lineEndHandler.setNext(lengthHandler);
        lengthHandler.setNext(valHandler);

        boolean isValid = lineEndHandler.isValid(s);
        System.out.println(isValid);

        //change logic using Stream API

        Predicate<String> lineEndHandler1 = statement -> statement.endsWith(";");
        Predicate<String> lengthHandler1 = statement -> statement.length() <= 50;
        Predicate<String> valHandler1 = statement -> !statement.contains("val");

        boolean isValid1 = lineEndHandler1
                .and(lengthHandler1)
                .and(valHandler1)
                .test(s);
        System.out.println(isValid1);

        Function<String, Function<Integer, String>> currying = getNumbers();
        System.out.println(currying.apply("Tens").apply(8)); // Eighty
        System.out.println(currying.apply("Ones").apply(2)); // Two

    }

    public static List<String> ones =
            Arrays.asList("Zero", "One", "Two", "Three", "Four",
                    "Five", "Six", "Seven", "Eight", "Nine");
    public static List<String> tens =
            Arrays.asList("Zero", "Ten", "Twenty", "Thirty", "Forty",
                    "Fifty", "Sixty", "Seventy", "Eighty", "Ninety");

    public static Function<String, Function<Integer, String>> getNumbers() {
        return units -> number -> {
            return units == "Ones" ? ones.get(number % 10)
                    : tens.get(number % 10);
        };

/*        class ChainOfResponsibilityDemo {

            *//**
             * Accepts a request and returns new request with data wrapped in the tag <transaction>...</transaction>
             *//*
            static RequestHandler wrapInTransactionTag = req ->
                    new Request(String.format("<transaction>%s</transaction>", req.getData()));

            *//**
             * Accepts a request and returns a new request with calculated digest inside the tag <digest>...</digest>
             *//*
            static RequestHandler createDigest = req -> {
                String digest = "";
                try {
                    final MessageDigest md5 = MessageDigest.getInstance("MD5");
                    final byte[] digestBytes = md5.digest(req.getData().getBytes("UTF-8"));
                    digest = new String(Base64.getEncoder().encode(digestBytes));
                } catch (Exception ignored) {
                    System.out.println("An error occurred");
                }
                return new Request(req.getData() + String.format("<digest>%s</digest>", digest));
            };

            *//**
             * Accepts a request and returns a new request with data wrapped in the tag <request>...</request>
             *//*
            static RequestHandler wrapInRequestTag = req ->
                    new Request(String.format("<request>%s</request>", req.getData()));

            *//**
             * It should represent a chain of responsibility combined from another handlers.
             * The format: commonRequestHandler = handler1.setSuccessor(handler2.setSuccessor(...))
             * The combining method setSuccessor may have another name
             *//*
            //static RequestHandler commonRequestHandler = // !!! write a combination of existing handlers here

            *//**
             * It represents a handler and has two methods: one for handling requests and other for combining handlers
             *//*
            @FunctionalInterface
            interface RequestHandler {

                // !!! write a method handle that accept request and returns new request here
                // it allows to use lambda expressions for creating handlers below

                Request handle(Request request);

                // !!! write a default method for combining this and other handler single one
                // the order of execution may be any but you need to consider it when composing handlers
                // the method may has any name

                default RequestHandler combine(RequestHandler requestHandler) {

                    return (request) -> requestHandler.handle(this.handle(request));
                }

            }

            *//**
             * Immutable class for representing requests.
             * If you need to change the request data then create new request.
             *//*
            static class Request {
                private final String data;

                public Request(String requestData) {
                    this.data = requestData;
                }

                public String getData() {
                    return data;
                }
            }

        }*/
    }
}
