/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author hrs
 */
public class NachrichtenSchreiber implements Encoder.Text<Nachricht> {

    @Override
    public void init(final EndpointConfig config) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String encode(Nachricht nachricht) throws EncodeException {
        return Json.createObjectBuilder()
                .add("message", nachricht.getText())
                .add("sender", nachricht.getSender())
                .add("received", nachricht.getEmpfangen().toString()).build()
                .toString();
    }
}
