export function uploadOptions() {
    const d = document

    d.addEventListener('change', (e) => {

        const $menu = d.querySelector('.consult__content')
        const $selec = d.querySelector('.consult__select')
        const value = e.target.value.split(' ')
        const $fragment = d.createDocumentFragment()

        const crearBoton = (btn, group, reference, referenceSon) => {
            const $button = d.createElement('button')
            $button.classList.add(btn);
            $button.classList.add(group);
            $button.setAttribute('data-datos', `${value[0]} ${value[1]}`);
            $button.textContent = 'Consultar'
            $fragment.appendChild($button)
            reference.insertBefore($fragment, referenceSon)

        }

        const crearBotonDos = (group) => {
            const $contentSection = d.createElement('div')
            const $label = d.createElement('label');
            const $input = d.createElement('input')
            $contentSection.classList.add(group)
            $label.textContent = value[1].charAt(0).toUpperCase() + value[1].slice(1) + ':'
            $label.setAttribute('for', 'datoConsulta')
            $input.setAttribute('type', 'text')
            $input.setAttribute('name', 'datoConsulta')
            $contentSection.appendChild($label)
            $contentSection.appendChild($input)
            $fragment.appendChild($contentSection)
            crearBoton('btn_Dos', 'groupTwo', $menu, $selec.nextSibling)
        }

        if (value[2] == 'Uno') {

            if (d.querySelector('.groupTwo')) {
                d.querySelectorAll('.groupTwo').forEach(element => {
                    $menu.removeChild(element)
                });
                crearBoton('btn_Uno', 'groupOne', $menu, $selec.nextSibling);
            } else {
                if (d.querySelector('.btn_Uno')) {
                    d.querySelector('.btn_Uno').setAttribute('data-datos',`${value[0]} ${value[1]}`)
                } else {
                    crearBoton('btn_Uno', 'groupOne', $menu, $selec.nextSibling);
                }
            }

        } else {
            if (d.querySelector('.groupTwo')) {
                if (d.querySelector('.btn_Uno')) {
                    $menu.removeChild(document.querySelector('.btn_Uno'))
                }
                d.querySelectorAll('.groupTwo').forEach(element => {
                    $menu.removeChild(element)
                });
                crearBotonDos('groupTwo')
            } else {
                if (d.querySelector('.btn_Uno')) {
                    $menu.removeChild(document.querySelector('.btn_Uno'))
                }
                crearBotonDos('groupTwo')
            }
        }
    })

}