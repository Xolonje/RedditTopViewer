import org.json.*;

public class Post {

    public String url  = "https://www.reddit.com/top.json";
    public JSONObject Top;
    public void JSONFetch()//Imports the JSON file and fetches the data from it
    {
        {
            try {
                Top = new JSONObject(url);
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
