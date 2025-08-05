import { BookOpenIcon, CalendarIcon, CodeIcon, CpuIcon, Grid3X3Icon } from "lucide-react";
import NavItem from "./components/NavItem";

export default function Aside() {
    return (
        <aside className="w-[20%] h-[100vh] bg-gray-100 text-black border-r-1 border-gray-300 p-[10px]">
            <div className="flex items-center gap-3 mb-2">
                <img className="w-8" src="logo_ufabc.png" />
                <h1 className="font-bold text-lg">UFABC</h1>
            </div>
            <input className="border-1 border-gray-300 rounded-md w-full px-2 py-1 mt-2" type="text" placeholder="Buscar matérias..." />

            <hr className="w-full my-3 border-gray-300" />

            <div className="flex flex-col gap-5">
                <div>
                    <h3 className="uppercase text-gray-500 mb-1">Navegação</h3>
                    <nav className="flex flex-col">
                        <NavItem Icon={BookOpenIcon} text="Matérias" />
                        <NavItem Icon={CalendarIcon} text="Quad Ideal" />
                    </nav>
                </div>

                <div>
                    <h3 className="uppercase text-gray-500 mb-1">Categorias</h3>
                    <nav>
                        <NavItem Icon={Grid3X3Icon} text="Todas as Matérias" />
                        <NavItem Icon={CpuIcon} text="Ciência e Tecnologia" />
                        <NavItem Icon={CodeIcon} text="Bacharelado em Ciência da Computação" />
                    </nav>
                </div>
            </div>

        </aside>
    )
}

