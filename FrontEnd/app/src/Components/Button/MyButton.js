import ReactiveButton from 'reactive-button';

function MyButton(props) {
    return (
        <ReactiveButton
            buttonState={props.state}
            onClick={props.onClick}
            color={props.color}
            idleText={props.idleText}
            loadingText={props.loadingText}
            successText={props.successText}
            errorText={props.errorText}
            type={props.type}
            className={'class1 class2'}
            style={{ borderRadius: '5px' }}
            outline={props.outline}
            shadow={props.shadow}
            rounded={props.rounded}
            size={props.size}
            block={props.black}
            messageDuration={props.messageDuration}
            disabled={props.disabled}
            buttonRef={props.buttonRef}
            width={props.width}
            height={props.height}
            animation={props.animation}
        />
    );
}

export default MyButton;