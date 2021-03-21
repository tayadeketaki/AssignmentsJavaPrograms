package firstOne;

import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class mockhelloworld {

    @Test
    public void mockHelloWorld()
    {
        stubFor(get(urlEqualTo("/some/thing"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("Hello world!")));
    }
}
