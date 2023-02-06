package com.example.apilibreria.bootstrap;

import com.example.apilibreria.models.Autor;
import com.example.apilibreria.models.Libro;
import com.example.apilibreria.repositories.AutorRepository;
import com.example.apilibreria.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    LibroRepository libroRepository;
    AutorRepository autorRepository;

    @Override
    public void run(String... args) throws Exception{
        libroRepository.save(new Libro("Cien años de soledad" , "Gabriel García Márquez", "https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1631642420-51O9mmoZLhL._SL500_.jpg?crop=1xw:1xh;center,top&resize=320%3A%2A","Nunca dejaré de recomendar Cien años de soledad, en mi opinión el mejor libro de Gabriel García Márquez. Cuenta la historia de Macondo y de la saga de los Buendía, cuyo espíritu de aventura los coloca en medio de señalados acontecimientos históricos que tuvieron lugar en Colombia. Retrata con sus virtudes y flaquezas a un repertorio de personajes entrañables con los que convives durante el periodo que estás leyendo la novela, y mucho después.\n" +
                "\n" +
                "La primera frase es tan impactante que muchos la tenemos grabada en la memoria \"Muchos años después, frente al pelotón de fusilamiento, el coronel Aureliano Buendía había de recordar aquella tarde remota en que su padre lo llevó a conocer el hielo\". Esas palabras son el preludio de la aventura fabulosa de una familia cuyos milagros, fantasías, obsesiones, tragedias, incestos y adulterios representan al mismo tiempo el mito y la historia, la tragedia y la comedia, la vida y la muerte. Su excelente prosa, la naturalidad de los diálogos y una trama ágil y dinámica hacen de este libro uno de mis favoritos.", 1967));

        libroRepository.save(new Libro("Nada" , "Carmen Laforet", "https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1631642719-41FXKOomDwS._SL500_.jpg?crop=1xw:1xh;center,top&resize=320%3A%2A","En el año en que se conmemora el nacimiento de la autora no podemos dejar pasar este titulazo. Una novela existencialista con tintes autobiográficos que narra la historia de Andrea, una joven huérfana que llega ilusionada a Barcelona para seguir sus estudios de Filosofía y Letras. Lo que creía que sería una vida excitante resulta un completo desengaño, ya que la universidad no cambia el rol que la sociedad da a las mujeres, que no es otro que la maternidad. En realidad, más que una novela de iniciación, es también un retrato de la sociedad burguesa y conservadora de los primeros años de la posguerra, sometida al franquismo y cargada de hambruna.\n" +
                "\n" +
                "Nada ganó el primer Premio Nadal el 6 de enero de 1944; el jurado prefirió la obra de Laforet a las presentadas por autores veteranos, eso muestra el carácter aperturista del premio. El periodista César González Ruano montó en cólera al enterarse que una \"jovencita\" le había \"quitado\" el premio. Lo raro no es que el premio lo ganara una mujer, sino que se permitiera su publicación. Por suerte a veces los censores se fijaban solo en escenas picantes o discursos políticos y olvidaban leer entre líneas.", 1944));

        libroRepository.save(new Libro("Crónicas marcianas" , "Ray Bradbury", "https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1631641147-41yZWABLHOL._SL500_.jpg?crop=1xw:1xh;center,top&resize=320%3A%2A","Esta colección de relatos es, después de Fahrenheit 451, probablemente la obra maestra de Ray Bradbury. Los cuentos giran en torno a la colonización de Marte por parte de la humanidad que abandona la Tierra con la intención de convertir el planeta rojo en una civilización de perritos calientes, sofás cómodos y limonada en el porche. Una auténtica reproducción de cualquier colonización que se haya dado en la historia del ser humano, en la que los colonizadores, buscando su bien personal, han dejado en el nuevo mundo enfermedades, injusticias y desolación. Uno cierra el libro, ve las noticias y solo puede pensar, como haría Bradbury, \"¿por qué no podemos simplemente vivir en la Tierra?\".", 1950));
        libroRepository.save(new Libro("El laberinto español" , "Gerarld Brenan", "https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1631640287-61y9JidhS9L._SL500_.jpg?crop=1xw:1xh;center,top&resize=320%3A%2A","Siempre he dicho que donde más he aprendido sobre España ha sido en Bristol, en esa universidad británica en la que leí a los mejores hispanistas: Paul Preston, Raymond Carr, Burnett Bolloten, y Hugh Thomas. Y por encima de todos ellos, la obra fundamental, El laberinto español, un ensayo sobre la historia social, económica y política de España antes de la Guerra Civil. Es el libro que yo recomiendo a cualquiera que quiera entender los contrasentidos de este país, las circunstancias que llevaron a la guerra, y que nunca deberíamos olvidar, por muchos años que pasen. En el Reino Unido se publicó originariamente en 1943, en España no llegó hasta 1978, Franco lo tenía prohibido por la dura crítica al régimen instaurado tras el golpe de estado que acabó con un gobierno elegido democráticamente.", 1943));
        autorRepository.save(new Autor("Alex","Cancelo","Hurtado","https://kinsta.com/es/wp-content/uploads/sites/8/2020/10/tipos-de-archivos-de-imagen.png"));


    }

}
