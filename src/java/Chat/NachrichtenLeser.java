/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.StringReader;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author katha
 */
public class NachrichtenLeser implements Decoder.Text<Nachricht> {
    
    @Override
	public void init(final EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public Nachricht decode(final String textMessage) throws DecodeException {
		JsonObject obj = Json.createReader(new StringReader(textMessage))
				.readObject();
                Nachricht nachricht = new Nachricht(obj.getString("text"), obj.getString("sender"));
		nachricht.setEmpfangen(new Date());
		return nachricht;
	}

	@Override
	public boolean willDecode(final String s) {
		return true;
	}
}
