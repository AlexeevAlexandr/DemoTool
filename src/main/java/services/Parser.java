package services;

import model.LineC;
import model.LineD;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private String tmplDate = "\\d{1,2}\\.\\d{1,2}\\.\\d{4}";
    private String tmplQuestion = "\\d*(\\.\\d*(\\.\\d*)?)?";
    private String tmplServiceId = "\\d*(\\.\\d*)?";
    private String tmplLineC = "C " + tmplServiceId + " " + tmplQuestion + " ([PN]) " + tmplDate+ " \\d*";
    private String tmplLineD = "D (" + tmplServiceId + "|\\*) (" + tmplQuestion + "|\\*) [PN] " + tmplDate+ "(-" + tmplDate+ ")?";
    private String sourceString;
    private List<LineD> linesD;

    public Parser(){}

    Parser(String inputString) {
        sourceString = inputString.replaceAll("[\t\n]", "").replaceAll(" {2,}+"," ").trim();
        if (!validInputString(sourceString)) {
            throw new IllegalArgumentException("Broken line structure");
        }

        linesD = parseToListD();
        int numberOfLines = getExpectedNumberOfLines(sourceString);
        int actuallySize = parseToListC().size() + parseToListD().size();

        if ( numberOfLines != actuallySize) {
            throw new IllegalArgumentException("Incorrect number of lines in input string! Expected: "
                    + numberOfLines + ", actually: " + actuallySize);
        }
    }

    private boolean validInputString(String inputString) {
        return inputString.matches("^\\d*(( " + tmplLineC + ")|( " + tmplLineD + "))*");
    }

    private List<LineC> parseToListC() {
        return parseToListC(tmplLineC);
    }

    List<LineC> parseToListC(String tmpl) {
        List<LineC> resultList = new ArrayList<>();

        Matcher matcher = Pattern.compile(tmpl).matcher(sourceString);
        while (matcher.find()) {
            String itemLine = sourceString.substring(matcher.start(), matcher.end());
            resultList.add(new LineC(itemLine));
        }
        return resultList;
    }

    private List<LineD> parseToListD() {
        List<LineD> resultList = new ArrayList<>();

        Matcher matcher = Pattern.compile(tmplLineD)
                .matcher(sourceString);
        while (matcher.find()) {
            String itemLine = sourceString.substring(matcher.start(), matcher.end());
            resultList.add(new LineD(itemLine));
        }
        return resultList;
    }

    private int getExpectedNumberOfLines(String inputString) {
        return Integer.parseInt(inputString.substring(0,inputString.indexOf(" ")));
    }

    public boolean isLineD(String line) {
        return line.matches(tmplLineD);
    }

    public boolean isLineC(String line) {
        return line.matches(tmplLineC);
    }

    String createTmplForSearchC(LineD lineD) {
        StringBuilder builder = new StringBuilder("C ");
        if (lineD.getServiceId().equals("*")) {
            builder.append(tmplServiceId).append(" ");
        } else {
            if (lineD.getVariationId().equals("")) {
                builder.append(String.format("((%s)|(%s.\\d*)?) ", lineD.getServiceId(), lineD.getServiceId()));
            } else {
                builder.append(String.format("%s.%s ",lineD.getServiceId(), lineD.getVariationId()));
            }
        }

        if (lineD.getQuestionTypeId().equals("*")) {
            builder.append(tmplQuestion).append(" ");
        } else {
            if (lineD.getCategoryId().equals("") && lineD.getSubCategoryId().equals("")) {
                builder.append(String.format("(%s(\\.\\d*(\\.\\d*)?)?) ", lineD.getQuestionTypeId()));
            } else if (lineD.getSubCategoryId().equals("")){
                builder.append(String.format("(%s(\\.%s(\\.\\d*)?)?) ", lineD.getQuestionTypeId(), lineD.getCategoryId()));
            } else {
                builder.append(String.format("(%s(\\.%s(\\.%s)?)?) ", lineD.getQuestionTypeId(), lineD.getCategoryId(), lineD.getSubCategoryId()));
            }
        }
        return builder.append("(P|N) ").append(tmplDate).append(" \\d*").toString();
    }

    List<LineD> getListLineD() {
        return this.linesD;
    }
}