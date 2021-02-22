export function uploadSection(type, section) {

    const tables = async (options) => {

        let { link, method, header, success } = options

        const result = await fetch(link, {
            method,
            header,
        })

        const html = (result.ok) ? result.text() : Promise.reject(result)
        const data = await html;

        success(data);
    }

    const getTables = () => {

        tables({
            link: `../components/${type}Component.html`,
            method: 'GET',
            header: {
                "Content-type": "text/html; charset=utf-8"
            },
            success: (res) => {
                document.querySelector(`.${section}`).innerHTML = res

            }
        })
    }

    getTables();
}
