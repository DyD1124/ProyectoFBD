export function clickElements() {
    const d = document;

    d.addEventListener('click', (e) => {

        const $menu = d.querySelector('.consult')
        const $seccion = d.querySelector('.disable')
        const $fragment = d.createDocumentFragment();

        const createFragment = () => {
            const $label = d.createElement('label')
            const $input = d.createElement('input')
            const $button = d.createElement('button')
            const $content = d.createElement('div')

            $content.classList.add('content')
            $label.setAttribute('for', 'numHabitacion')
            $label.textContent = 'Habitacion'
            $input.setAttribute('type', 'text')
            $input.setAttribute('name', 'numHabitacion')
            $button.setAttribute('data-check', 'Check - Out')
            $button.textContent = 'Check - Out'

            $content.appendChild($label)
            $content.appendChild($input)
            $content.appendChild($button)

            $fragment.appendChild($content)
            $menu.appendChild($fragment)
        }

        if (e.target.textContent == 'Consultas') {
            $menu.classList.contains('disableContent')?$menu.classList.remove('disableContent'):""
            if (d.querySelector('.content')) {
                d.querySelector('.content').classList.add('disable')
                $seccion.classList.add('consult__active')
            }else{
                $seccion.classList.add('consult__active')
            }
        }
        if (e.target.textContent == 'Check-in / Check - out') {
            $menu.classList.contains('disableContent')?$menu.classList.remove('disableContent'):""
            if (d.querySelector('.consult__active')) {
                $seccion.classList.remove('consult__active')
                d.querySelector('.content')?d.querySelector('.content').classList.remove('disable'):createFragment()
                
            } else {
                d.querySelector('.content') ? "" : createFragment()
            }

        }
        if (e.target.textContent == 'Reporte') {
            $menu.classList.add('disableContent')
        }
    })

}