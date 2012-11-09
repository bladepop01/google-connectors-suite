
package org.mule.module.gmail.oauth;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Generated;
import org.mule.api.MessagingException;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;
import org.mule.config.i18n.MessageFactory;

@Generated(value = "Mule DevKit Version 3.3.1", date = "2012-11-09T06:16:18-03:00", comments = "Build UNNAMED.1297.150f2c9")
public class ExtractAuthorizationCodeMessageProcessor implements MessageProcessor
{

    private Pattern pattern;

    public ExtractAuthorizationCodeMessageProcessor(Pattern pattern) {
        this.pattern = pattern;
    }

    public MuleEvent process(MuleEvent event)
        throws MuleException
    {
        try {
            event.getMessage().setInvocationProperty("_oauthVerifier", extractAuthorizationCode(event.getMessageAsString()));
        } catch (Exception e) {
            throw new MessagingException(MessageFactory.createStaticMessage("Could not extract OAuth verifier"), event, e);
        }
        return event;
    }

    private String extractAuthorizationCode(String response)
        throws Exception
    {
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()&&(matcher.groupCount()>= 1)) {
            return URLDecoder.decode(matcher.group(1), "UTF-8");
        } else {
            throw new Exception(String.format("OAuth authorization code could not be extracted from: %s", response));
        }
    }

}