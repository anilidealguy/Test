package com.anil.learning;
import java.util.Arrays;


public class HtmlPostProcessor {
    
    public String doCenterAlign(String bipReport) {
        if (AppsLogger.isEnabled(AppsLogger.FINER)) {
            AppsLogger.write(this, "Entering doCenterAlign", AppsLogger.FINER);
        }
        long startTime = System.currentTimeMillis();
        if(bipReport != null && bipReport.length() > 0) {
            String tabString = "";
            String tabClosingString = "";
            try {
                tabString = tableCenterStyle();
                tabClosingString = tableClosingBodyStyle();
                //   String tableString = "<body><table style=\"margin:0 auto\"><tr><td>";
                bipReport = bipReport.replaceFirst("<body>", tabString);
                //  String divClose1 = "</td></tr></table></body>";
                String toReplace="</body>";
                int lastBTInd = bipReport.lastIndexOf(toReplace);
                /*
                * to replace the last occurence of </body>
                */
                if(lastBTInd > -1) {
                    bipReport = bipReport.substring(0, lastBTInd) + tabClosingString + bipReport.substring(lastBTInd + toReplace.length(), bipReport.length());
                }
            } catch(Exception e) {
                if(AppsLogger.isEnabled(AppsLogger.SEVERE)) {
                    AppsLogger.write(this, "Exception N GETTING THE FILe, exception throwed " + e+"\n"+Arrays.toString(e.getStackTrace()).replace(",", "\n"), AppsLogger.SEVERE);
                }
            }
        } else {
            if (AppsLogger.isEnabled(AppsLogger.FINEST)) {
                AppsLogger.write(this, "doCenterAlign: bip report is null", AppsLogger.FINEST);
            }
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        if(AppsLogger.isEnabled(AppsLogger.FINER)) {
            AppsLogger.write(this, "Exiting doCenterAlign and time taken " + estimatedTime + " ms", AppsLogger.FINER);
        }
        return bipReport;
    }
    
    private String tableCenterStyle() {
        StringBuilder sb = new StringBuilder("<body>");
        sb.append("<!-- adding this  to fix the outlook stretch issue and center align the mails -->\n");
        sb.append("<span id=\"BIPHTML\">\n");
        sb.append("<table style=\"margin:0 auto; width:604px\" align=\"center\"><tr><td>\n");       
        sb.append("     <table   cellspacing=\"0\" style=\"width:100%\">\n");     
        sb.append("       <tr>  \n");
        sb.append("           <td style=\"padding:0px;margin:0px;\"></td>\n");       
        sb.append("           <td style=\"padding:0px;margin:0px;\" width=\"604\">\n");
        sb.append("        <!--  done-->\n");
        sb.append("<!--BIP content here -->\n");
        return sb.toString();
    }
    
    private String tableClosingBodyStyle() {
        StringBuilder sb = new StringBuilder("");
        sb.append("       <!--outlook fix ends here -->\n");
        sb.append("        </td>\n");
        sb.append("        <td style=\"padding:0px;margin:0px;\"></td>\n");
        sb.append("    </tr>\n");
        sb.append("  </table>  \n");
        sb.append("</td></tr>  \n");
        sb.append("</table></span>\n");
        sb.append("<!-- done-->\n");
        sb.append("</body>\n");
        return sb.toString();
    }
}
