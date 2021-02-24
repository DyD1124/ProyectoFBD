export function uploadSection(type, section, parametros = "") {

    const d = document;
    const getHTML = (options) => {
        let {url, success, error} = options
        const xhr = new XMLHttpRequest();

        xhr.addEventListener('readystatechange', (e) => {
            if (xhr.readyState !== 4)
                return;

            if (xhr.status >= 200 && xhr.status <= 300) {
                let html = xhr.responseText;
                success(html)
            } else {
                let message = xhr.statusText || "Ocurrio un error";
                error(`Error ${xhr.status}: ${message}`)
            }
        });

        xhr.open("GET", url);
        // El content type es de tipo text/html
        xhr.setRequestHeader("Content-type", "text/html; charset=utf-8");
        xhr.send()
    }

    const getHTMLS = () => {
        getHTML({
<<<<<<< HEAD
            url: type+`Component.jsp`,
            success: (html) => {

                document.querySelector(`.`+section).innerHTML = html
=======
            url: `${type}Component.jsp`+parametros,
            success: (html) => {
                document.querySelector(`.${section}`).innerHTML = html
                console.log("aca");
>>>>>>> f22487b73de0ab8f604340ff377b8e81bdec621a
            },
            error: (err) => {
                // Aqui introduciriamos el error en la pagina.
            }
        });

    }
    getHTMLS();
}