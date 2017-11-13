package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
        System.out.println(bodyText);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        int yht = 0;
        int teht = 0;
        System.out.println("Opiskelijanumero: " + studentNr);
        for (Submission submission : subs) {
            System.out.println(submission);
            yht += submission.getHours();
            teht += submission.getExercises().size();
        }
        System.out.println("Tehtäviä yhteensä: " + teht);
        System.out.println("Aikaa käytetty: " + yht);

    }
}
