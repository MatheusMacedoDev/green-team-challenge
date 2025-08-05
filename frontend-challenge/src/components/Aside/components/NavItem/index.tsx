interface Props {
    text: string,
    Icon: React.ElementType
}

export default function NavItem({ text, Icon }: Props) {
    return (
        <a className="flex gap-2 items-center p-2 rounded-md hover:bg-gray-300" href="">
            <Icon size={16} />
            {text}
        </a>
    )
}

