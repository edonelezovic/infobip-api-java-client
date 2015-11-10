package infobip.api.client;

import infobip.api.config.Configuration;
import infobip.api.model.sms.mt.logs.SMSLogsResponse;
import com.google.gson.GsonBuilder;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * This is a generated class and is not intended for modification!
 * TODO: Point to Github contribution instructions
 */
public class GetSentSmsLogs {
    private final Configuration configuration;

    public GetSentSmsLogs(Configuration configuration) {
        this.configuration = configuration;
    }

    interface GetSentSmsLogsService {
        @GET("/sms/1/logs")
        SMSLogsResponse execute(@Query("from") java.lang.String from, @Query("to") java.lang.String to, @Query
                ("bulkId") java.lang.String[] bulkId, @Query("messageId") java.lang.String[] messageId, @Query
                                        ("generalStatus") java.lang.String generalStatus, @Query("sentSince") infobip.api
                .config.FormattedDate
                                        sentSince, @Query("sentUntil") infobip.api.config.FormattedDate sentUntil, @Query
                                        ("limit") java.lang.Integer
                                        limit, @Query("mcc") java.lang.String mcc, @Query("mnc") java.lang.String mnc);
    }

    public SMSLogsResponse execute(java.lang.String from, java.lang.String to, java.lang.String[] bulkId, java.lang
            .String[] messageId, java.lang.String generalStatus, infobip.api.config.FormattedDate sentSince, infobip.api.config
                                           .FormattedDate sentUntil, java.lang.Integer limit, java.lang.String mcc,
                                   java.lang.String mnc) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(configuration.getBaseUrl())
                .setRequestInterceptor(getRequestInterceptor())
                .setConverter(new GsonConverter(new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                        .create()))
                .build();
        GetSentSmsLogsService service = restAdapter.create(GetSentSmsLogsService.class);
        return service.execute(from, to, bulkId, messageId, generalStatus, sentSince, sentUntil, limit, mcc, mnc);
    }

    private RequestInterceptor getRequestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                if (configuration != null && configuration.getAuthorizationHeader() != null) {
                    request.addHeader("Authorization", configuration.getAuthorizationHeader());
                }
            }
        };
    }
}