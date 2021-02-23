import { uploadSection } from './uploadMenu.js'

        export function sectionUser() {

            const d = document;

            d.addEventListener('click', (e) => {
                console.log(e.target)
                if (e.target.textContent == 'Reserva') {
                    console.log('Carga')
                    e.preventDefault()
                    uploadSection('components/reserva', 'main')
                }
                if (e.target.textContent == 'Mi reserva') {
                    e.preventDefault()
                    uploadSection('components/miReserva', 'main')
                }
            });
        }
