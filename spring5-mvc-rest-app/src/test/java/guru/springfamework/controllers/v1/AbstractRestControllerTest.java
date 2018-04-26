package guru.springfamework.controllers.v1;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by rubatsirochiripa on 6/4/2018.
 */
public abstract class AbstractRestControllerTest {
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
