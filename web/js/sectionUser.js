import { uploadSection } from './uploadMenu.js'

        export function sectionUser() {

            const d = document;

            d.addEventListener('click', (e) => {
                console.log(e.target)
                if (e.target.textContent == 'Reserva') {
                    e.preventDefault()
                    uploadSection('reserva', 'main')
                }
                if (e.target.textContent == 'Mi reserva') {
                    e.preventDefault()
                    uploadSection('miReserva', 'main')
                }
            });
        }
