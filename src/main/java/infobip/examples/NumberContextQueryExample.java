package infobip.examples;

import infobip.api.client.NumberContextQuery;
import infobip.api.config.BasicAuthConfiguration;
import infobip.api.model.nc.query.NumberContextRequest;
import infobip.api.model.nc.query.NumberContextResponse;
import infobip.api.model.nc.query.NumberContextResponseDetails;

import java.util.Collections;

public class NumberContextQueryExample extends Example {

    public static void main(String[] args) {

        NumberContextQuery client = new NumberContextQuery(new BasicAuthConfiguration(USERNAME, PASSWORD));

        NumberContextRequest requestBody = new NumberContextRequest();
        requestBody.setTo(Collections.singletonList(TO));

        NumberContextResponse response = client.execute(requestBody);

        for (NumberContextResponseDetails sentRequestInfo : response.getResults()) {
            System.out.println("Phone number: " + sentRequestInfo.getTo());
            System.out.println("MccMnc: " + sentRequestInfo.getMccMnc());
            System.out.println("Original country prefix: " + sentRequestInfo.getOriginalNetwork().getCountryPrefix());
            System.out.println("Original network prefix: " + sentRequestInfo.getOriginalNetwork().getNetworkPrefix());
            System.out.println("Serving MSC: " + sentRequestInfo.getServingMSC());
            System.out.println("------------------------------------------------");
        }
    }
}
